interface ChipSelectProps {
  options: { label: string; value: string }[]
  selected: string[]
  onChange: (selected: string[]) => void
}

export function ChipSelect({ options, selected, onChange }: ChipSelectProps) {
  const toggle = (value: string) => {
    onChange(
      selected.includes(value)
        ? selected.filter(v => v !== value)
        : [...selected, value]
    )
  }

  return (
    <div className="flex flex-wrap gap-2">
      {options.map(opt => (
        <button
          key={opt.value}
          type="button"
          onClick={() => toggle(opt.value)}
          className={`px-4 py-2 rounded-full text-sm font-medium border transition-all duration-200 ${
            selected.includes(opt.value)
              ? 'bg-primary text-white border-primary'
              : 'bg-white text-text-secondary border-gray-200'
          }`}
        >
          {opt.label}
        </button>
      ))}
    </div>
  )
}
