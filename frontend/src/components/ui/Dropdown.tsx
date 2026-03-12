import { ChevronDown } from 'lucide-react'
import type { SelectHTMLAttributes } from 'react'

interface DropdownProps extends SelectHTMLAttributes<HTMLSelectElement> {
  label: string
  options: { label: string; value: string }[]
}

export function Dropdown({ label, options, className = '', ...props }: DropdownProps) {
  return (
    <div className={className}>
      <label className="block text-sm font-medium text-text-secondary mb-1">{label}</label>
      <div className="relative">
        <select
          className="w-full appearance-none bg-white border border-gray-200 rounded-xl px-4 py-3 pr-10 text-sm focus:outline-none focus:border-primary"
          {...props}
        >
          {options.map(opt => (
            <option key={opt.value} value={opt.value}>{opt.label}</option>
          ))}
        </select>
        <ChevronDown className="absolute right-3 top-1/2 -translate-y-1/2 w-4 h-4 text-text-secondary pointer-events-none" />
      </div>
    </div>
  )
}
