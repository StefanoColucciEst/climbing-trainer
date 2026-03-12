interface ToggleProps {
  options: { label: string; value: string }[]
  value: string
  onChange: (value: string) => void
}

export function Toggle({ options, value, onChange }: ToggleProps) {
  return (
    <div className="flex bg-gray-100 rounded-xl p-1">
      {options.map(opt => (
        <button
          key={opt.value}
          onClick={() => onChange(opt.value)}
          className={`flex-1 py-2 px-4 rounded-lg text-sm font-medium transition-all duration-200 ${
            value === opt.value
              ? 'bg-primary text-white shadow-sm'
              : 'text-text-secondary'
          }`}
        >
          {opt.label}
        </button>
      ))}
    </div>
  )
}
