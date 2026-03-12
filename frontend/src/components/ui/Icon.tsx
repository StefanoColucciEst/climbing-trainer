import * as icons from 'lucide-react'
import type { LucideProps } from 'lucide-react'

interface IconProps extends LucideProps {
  name: keyof typeof icons
}

export function Icon({ name, ...props }: IconProps) {
  const LucideIcon = icons[name] as React.ComponentType<LucideProps>
  if (!LucideIcon) return null
  return <LucideIcon {...props} />
}
